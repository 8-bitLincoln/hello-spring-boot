package com.example.beans;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class CustomScopeConfigurer implements Scope
{

   private Map<String, Pair<LocalDateTime, Object>> map = new HashMap<>();

   @Override
   public Object get(String name, ObjectFactory<?> objectFactory)
   {
      if (map.containsKey(name))
      {
         int delay = LocalDateTime.now().getSecond() - map.get(name).getKey().getSecond();
         if (delay > 3)
         {
            map.put(name, new Pair(LocalDateTime.now(), objectFactory.getObject()));
         }
      }
      else
      {
         map.put(name, new Pair(LocalDateTime.now(), objectFactory.getObject()));
      }
      return map.get(name).getValue();
   }

   @Override
   public Object remove(String s)
   {
      return null;
   }

   @Override
   public void registerDestructionCallback(String s, Runnable runnable)
   {

   }

   @Override
   public Object resolveContextualObject(String s)
   {
      return null;
   }

   @Override
   public String getConversationId()
   {
      return null;
   }
}
