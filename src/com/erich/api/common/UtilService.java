package com.erich.api.common;

public interface UtilService {
    int createRandomInteger(int start, int gapBetweenStartAndEnd);
    double createRandomDouble(double start, double gapBetweenStartAndEnd);

    String createRandomName();

    String createRandomTitle();

    String createRandomContent();

    String createRandomCompany();
    String createRandomUsername();

    String createRandomJob();


}
