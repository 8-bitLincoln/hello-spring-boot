package com.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Scope("session")
public class BeanScopeSession
{
   private LocalTime created = LocalTime.now();

   public LocalTime getCreated()
   {
      return created;
   }
}
