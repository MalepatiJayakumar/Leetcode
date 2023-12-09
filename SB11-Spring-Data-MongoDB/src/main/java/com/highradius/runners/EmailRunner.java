package com.highradius.runners;

import java.util.Arrays;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EmailRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("*************************************");
		
		//Printing string values provided by params, not key value pairs
		System.out.println("EmailRunner.run() >> args " + Arrays.asList(args.getSourceArgs()));
		
		//Printing key value pairs
		Set<String> optionNames = args.getOptionNames();
		System.out.println("EmailRunner.run() >> optional names :: "+optionNames);
		optionNames.forEach(name->{
			System.out.println(args.getOptionValues(name));
		});
	}
}
