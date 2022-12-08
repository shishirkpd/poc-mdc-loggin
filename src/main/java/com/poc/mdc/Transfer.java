package com.poc.mdc;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transfer {
    private String transactionId;
    private String sender;
    private Long amount;

}