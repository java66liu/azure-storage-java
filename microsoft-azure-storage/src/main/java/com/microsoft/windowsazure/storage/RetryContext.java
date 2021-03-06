/**
 * Copyright Microsoft Corporation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.microsoft.windowsazure.storage;

import com.microsoft.windowsazure.storage.core.Utility;

/**
 * Represents the context for a retry of a request made against the storage services.
 */
public final class RetryContext {
    /**
     * The location that the next retry should target.
     */
    private final StorageLocation nextLocation;

    /**
     * The location mode for subsequent retries.
     */
    private final LocationMode locationMode;

    /**
     * Gets the number of retries for the given operation.
     */
    public final int currentRetryCount;

    /**
     * Gets the last request's results.
     */
    public final RequestResult lastRequestResult;

    public RetryContext(int currentRetryCount, RequestResult lastRequestResult, StorageLocation nextLocation,
            LocationMode locationMode) {
        this.currentRetryCount = currentRetryCount;
        this.lastRequestResult = lastRequestResult;
        this.nextLocation = nextLocation;
        this.locationMode = locationMode;
    }

    /**
     * @return the currentRetryCount
     */
    public int getCurrentRetryCount() {
        return currentRetryCount;
    }

    /**
     * @return the lastRequestResult
     */
    public RequestResult getLastRequestResult() {
        return lastRequestResult;
    }

    /**
     * @return the locationMode
     */
    public LocationMode getLocationMode() {
        return locationMode;
    }

    /**
     * @return the nextLocation
     */
    public StorageLocation getNextLocation() {
        return this.nextLocation;
    }

    /**
     * Returns a string that represents the current {@link RetryContext} instance.
     */
    @Override
    public String toString() {
        return String.format(Utility.LOCALE_US, "(%s,%s)", this.currentRetryCount, this.locationMode);
    }

}
