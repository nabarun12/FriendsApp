package com.example.restcall;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("office")
@Component
public interface CallFeignClientApi {

	@RequestMapping("/service/getData")
	public String getOfficeData();
}
