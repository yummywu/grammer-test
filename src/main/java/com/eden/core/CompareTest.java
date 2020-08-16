package com.eden.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.eden.dto.ServiceProviderLookupDto;

public class CompareTest {

	public static void main(String[] args) {
		List<ServiceProviderLookupDto> spList = new ArrayList<ServiceProviderLookupDto>();
		ServiceProviderLookupDto spA = new ServiceProviderLookupDto("oocl", "B", "darrier", "ZHA");
		ServiceProviderLookupDto spB = new ServiceProviderLookupDto("oocl", "B", "carrier", "ZHA");
		ServiceProviderLookupDto spC = new ServiceProviderLookupDto("oocl", "C", "carrier", "ZHA");
		ServiceProviderLookupDto spD = new ServiceProviderLookupDto("oocl", "D", "carrier", "ZHA");
		spList.add(spA);
		spList.add(spB);
		spList.add(spD);
		spList.add(spC);
		System.out.println(spList);

		// Collections.sort(spList);
		Collections.sort(spList, new Comparator<ServiceProviderLookupDto>() {
			public int compare(ServiceProviderLookupDto sp1, ServiceProviderLookupDto sp2) {
				if (sp1.ref.compareTo(sp2.ref) != 0) {
					return sp1.ref.compareTo(sp2.ref);
				} else if (sp1.type.compareTo(sp2.type) != 0) {
					return sp1.type.compareTo(sp2.type);
				} else {
					return 0;
				}
			}
		});
		System.out.println(spList);

	}

}