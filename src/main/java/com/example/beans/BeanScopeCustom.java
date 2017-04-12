package com.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Scope("custom")
public class BeanScopeCustom
{
   private LocalTime created = LocalTime.now();

   public LocalTime getCreated()
   {
      return created;
   }
}
