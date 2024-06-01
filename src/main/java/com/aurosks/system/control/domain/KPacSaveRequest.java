package com.aurosks.system.control.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class KPacSaveRequest {
    private String title;
    private String description;
}
