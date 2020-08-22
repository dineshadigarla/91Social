package com.social.bike;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.social.assembly.Gear;
import com.social.seating.Leather;
import com.social.wheel.Tube;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Component
@Scope("prototype")
@Slf4j
public class IndividualTask implements Runnable{
	
	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private InteractionContext interactionContext;
	
	@Autowired
	private Cycle bike;
	
    private JsonNode jsonNode = null;
    private int counter=0;
    
    public IndividualTask() {
    	
    }

    public IndividualTask(int counter,JsonNode jsonNode) {
        this.jsonNode = jsonNode;
        this.counter=counter;
        
    }
    
    public String getName() {
    	return this.counter+"";
    }
 
    public JsonNode getJsonNode() {
        return this.jsonNode;
    }
 
    public void run() {
        try {
        	interactionContext.setCounterId(counter);
        	map(jsonNode);
        	bike.calculatePrice();
        	try {
				log.info(mapper.writeValueAsString(jsonNode));
			} catch (JsonProcessingException e1) {
				e1.printStackTrace();
			}
        	ObjectNode objectNode = mapper.createObjectNode();
        	objectNode.put("counterId", interactionContext.getCounterId());
        	objectNode.put("cycleName", interactionContext.getCycleName());
        	objectNode.put("handleBarWithBrakesPrice", interactionContext.getHandleBarWithBrakesPrice());
        	objectNode.put("SeatingPrice", interactionContext.getSeatingPrice());
        	objectNode.put("WheelPrice", interactionContext.getWheelPrice());
        	objectNode.put("chainAssemblyPrice", interactionContext.getChainAssemblyPrice());
        	objectNode.put("TotalPrice", interactionContext.getTotalPrice());
        	try {
				log.info(mapper.writeValueAsString(objectNode));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	interactionContext.reset();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
    public void map(JsonNode jsonNode){
    	String cycleName=jsonNode.get("name").asText();
    	interactionContext.setCycleName(cycleName);
		JsonNode seating=jsonNode.get("seating");
		Leather leather=bike.getSeating().getLeather();
		leather.setIsLeather(seating.get("isLeather").asText().equals("true"));
	    Gear gear=bike.getChainAssembly().getGear();
	    gear.setIsGear(jsonNode.get("gear").get("isGear").asText().equals("true"));
	    
	    Tube tube=bike.getWheel().getTube();
	    tube.setIsTube(jsonNode.get("tube").get("isTube").asText().equals("true"));
	    
	}

}
