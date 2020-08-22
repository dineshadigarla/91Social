package com.social.bike;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CycleTask {
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private Cycle bike;
	
	@Autowired
	public ApplicationContext applicationContext;
	

	@SneakyThrows
	public void totalPrice(String arg0,String arg1) {
		String jsonString=readText(arg1);
    	JsonNode arrayNode= mapper.readTree(jsonString);
    	setPrices();
    	log.info("Price is "+bike.calculatePrice());
    	BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);
 
    	ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
                                            10, 5000, TimeUnit.MILLISECONDS, blockingQueue);
 
        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable r,
                    ThreadPoolExecutor executor) {
                log.info("DemoTask Rejected : "
                        + ((IndividualTask) r).getName());
                log.info("Waiting for a second !!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("Lets add another time : "
                        + ((IndividualTask) r).getName());
                executor.execute(r);
            }
        });
        executor.prestartAllCoreThreads();
        int counter=1;
        if (arrayNode.isArray()) {
            for (JsonNode jsonNode : arrayNode) {
            	log.info("Adding Task : " + counter);
            	IndividualTask demoTask=applicationContext.getBean(IndividualTask.class,counter,jsonNode); 
                executor.execute(demoTask);              
                counter++;
            }
            
        }
        System.out.println("entered here");
    }
	
	private String readText(String file) {
		String text="";
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
			int val = 0;
			while ((val = bufferedReader.read()) != -1) {
				text += (char) val;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return text;
	}
	
		@SneakyThrows
		private void setPrices() {
			InputStream inputStream = TypeReference.class
					.getResourceAsStream("/json/templates.json");
			String jsonString = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
			ArrayNode arrayNode= (ArrayNode) mapper.readTree(jsonString);
			JsonNode jsonNode=arrayNode.get(0);
			mapFields(jsonNode);
		}
		
		private void mapFields(JsonNode jsonNode) {
			bike.getWheel().getSpoke().setPrice(Double.parseDouble(jsonNode.get("wheel").get("spoke").asText()));
			bike.getWheel().getTube().setPrice(Double.parseDouble(jsonNode.get("wheel").get("tube").asText()));
			bike.getWheel().getTyre().setPrice(Double.parseDouble(jsonNode.get("wheel").get("tyre").asText()));
			bike.getChainAssembly().getChain().setPrice(Double.parseDouble(jsonNode.get("chainAssembly").get("chain").asText()));
			bike.getChainAssembly().getGear().setPrice(Double.parseDouble(jsonNode.get("chainAssembly").get("gear").asText()));
			bike.getChainAssembly().getPedal().setPrice(Double.parseDouble(jsonNode.get("chainAssembly").get("Pedal").asText()));
			bike.getChainAssembly().getSpocket().setPrice(Double.parseDouble(jsonNode.get("chainAssembly").get("Spocket").asText()));
			bike.getHandleBarWithBrakes().getBrakes().setPrice(Double.parseDouble(jsonNode.get("handleBarWithBrakes").get("brakes").asText()));
			bike.getHandleBarWithBrakes().getHandleBar().setPrice(Double.parseDouble(jsonNode.get("handleBarWithBrakes").get("handleBar").asText()));
			bike.getSeating().getLeather().setPrice(Double.parseDouble(jsonNode.get("seating").get("leather").asText()));
		}

}

