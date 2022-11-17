package com.dev.tover.dtos;

import com.sun.istack.NotNull
import lombok.Data;
import lombok.Getter;
import net.bytebuddy.implementation.bind.annotation.Empty;

@Getter
@Data
public class EventTypeDTO {
   String name;
   Double price;
}
