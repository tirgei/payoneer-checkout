package com.tirgei.data.utils;

/**
 * Response class containing different data loading states and resultant response data/error message
 * @param <T> - Type of data expected as result
 */
public class NetworkResponse <T> {
    private NetworkStatus status;
    private T data;
    private Exception exception;

    private NetworkResponse(NetworkStatus status, T data, Exception exception) {
        this.status = status;
        this.data = data;
        this.exception = exception;
    }

    public static <T> NetworkResponse <T> loading() {
        return new NetworkResponse(NetworkStatus.LOADING, null, null);
    }

    public static <T> NetworkResponse <T> success(T data) {
        return new NetworkResponse(NetworkStatus.SUCCESS, data, null);
    }

    public static <T> NetworkResponse <T> error(Exception e) {
        return new NetworkResponse(NetworkStatus.ERROR, null, e);
    }


}
