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

/**
 * Class representing a set of stats pertaining to a cloud storage service.
 */
public class ServiceStats {

    /**
     * The geo-replication stats.
     */
    private GeoReplicationStats geoReplication;

    protected ServiceStats() {

    }

    /**
     * @return the geoReplication
     */
    public GeoReplicationStats getGeoReplication() {
        return geoReplication;
    }

    /**
     * @param geoReplication
     *            the geoReplication to set
     */
    protected void setGeoReplication(GeoReplicationStats geoReplication) {
        this.geoReplication = geoReplication;
    }
}
