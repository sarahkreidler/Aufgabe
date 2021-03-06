package com.programcreek.helloworld;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

// tag::setup[]
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	// end::setup[]

	// tag::readerwriterprocessor[]
	@Bean
	public FlatFileItemReader<Mapping> reader() {
		return new FlatFileItemReaderBuilder<Mapping>()
				.name("mappingItemReader")
				.resource(new ClassPathResource("mapping.csv"))
				.delimited()
				.names(new String[]{"isin", "tradeid"})
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Mapping>() {{
					setTargetType(Mapping.class);
				}})
				.build();
	}

	@Bean
	public MappingItemProcessor processor() {
		return new MappingItemProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<Mapping> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Mapping>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO mapping (isin, tradeid) VALUES (:isin, :tradeid)")
				.dataSource(dataSource)
				.build();
	}


	// end::readerwriterprocessor[]

	// tag::jobstep[]
	//@Bean
	//public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
	//	return jobBuilderFactory.get("importUserJob")
	//			.incrementer(new RunIdIncrementer())
	//			.listener(listener)
	//			.flow(step1)
	//			.end()
	//			.build();
	//}


	//@Bean
	//public Step step1(JdbcBatchItemWriter<Mapping> writer) {
	//	return stepBuilderFactory.get("step1")
	//			.<Mapping, Mapping> chunk(10)
	//			.reader(reader())
	//			.processor(processor())
	//			.writer(writer)
	//			.build();
	//}
	// end::jobstep[]
}
