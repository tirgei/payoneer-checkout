package com.tirgei.domain.usecases;

/**
 * This class is the base class for use cases used to request data from the respective repository
 * @param <Result> - Result from the UseCase
 */
public interface BaseUseCase<Result> {

    /**
     * This handles the respective action
     * @return - returns result based on the action
     */
    Result invoke();

}
