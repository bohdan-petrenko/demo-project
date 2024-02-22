package com.bp.dp.api;

import java.time.ZonedDateTime;
import java.util.Optional;

import com.bp.dp.api.model.MoneyTransferType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("user/{userId}/accounts{accountId}/money-transfers")
public class MoneyTransferController {

	@GetMapping
	public void getMoneyTransfers(@PathVariable String userId, @PathVariable String accountId,
			@RequestParam(defaultValue = "0") int pageNumber) {

	}

	@GetMapping("find")
	public void findMoneyTransfersInTimeRange(
			@PathVariable String userId,
			@PathVariable String accountId,
			@RequestParam(required = false) Optional<ZonedDateTime> fromDate,
			@RequestParam(required = false) Optional<ZonedDateTime> toDate,
			@RequestParam(required = false) Optional<String> fromAmount,
			@RequestParam(required = false) Optional<String> toAmount,
			@RequestParam(required = false) Optional<MoneyTransferType> paymentType,
			@RequestParam(defaultValue = "0") int pageNumber) {

	}


}
