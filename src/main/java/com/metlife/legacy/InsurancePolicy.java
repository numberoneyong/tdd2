package com.metlife.legacy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class InsurancePolicy {
    private String policyNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private double basePremium;
    // 수십 라인의 코드

    public InsurancePolicy(String customerNumber, LocalDate startDate, LocalDate endDate, double basePremium) {
        this.policyNumber = customerNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.basePremium = basePremium;
        // 수십 라인의 초기화
    }

    public double calculatePremium() {
        double finalPremium = basePremium;

        // 수백라인의 코드
        // 수백라인의 코드
        // 수백라인의 코드
        // 수백라인의 코드
        // 수백라인의 코드

        // 보험 가입 기간에 따른 할인 적용
        if (ChronoUnit.YEARS.between(startDate, endDate) > 5) {
            finalPremium *= 0.9; // 10% 할인
        }

        // 특정 고객 할인 로직 (데이터베이스 조회)
        DatabaseConnection db = new DatabaseConnection();
        boolean isLoyalCustomer = db.checkLoyaltyStatus(policyNumber);

        if (isLoyalCustomer) {
            finalPremium *= 0.95; // 5% 추가 할인
        }

        // 수백라인의 코드
        // 수백라인의 코드
        // 수백라인의 코드
        // 수백라인의 코드
        // 수백라인의 코드

        return finalPremium;
    }
}
