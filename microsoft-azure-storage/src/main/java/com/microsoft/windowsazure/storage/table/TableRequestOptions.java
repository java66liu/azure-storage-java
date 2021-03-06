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

package com.microsoft.windowsazure.storage.table;

import com.microsoft.windowsazure.storage.RequestOptions;
import com.microsoft.windowsazure.storage.core.Utility;

/**
 * Represents a set of timeout, payload format, and retry policy options that may be specified for a table operation
 * request.
 */
public class TableRequestOptions extends RequestOptions {

    /**
     * The interface whose function is used to get the <see cref="EdmType"/> for an entity property
     * given the partition key, row, key, and the property name, if the interface is implemented
     */
    public interface PropertyResolver {

        /**
         * Given the partition key, row, key, and the property name, produces the EdmType
         * 
         * @param pk
         *            The partition key
         * @param rk
         *            The row key
         * @param key
         *            The property name
         * @param value
         *            The property value
         * @return
         *         EdmType of the property
         */
        public EdmType propertyResolver(String pk, String rk, String key, String value);

    }

    /**
     * The interface whose function is used to get the <see cref="EdmType"/> for an entity property
     * given the partition key, row, key, and the property name, if the interface is implemented
     */
    private PropertyResolver propertyResolver;

    /**
     * The <see {@link TablePayloadFormat} that is used for any table accessed with this {@link TableRequest} object.
     * 
     * Default is Json Minimal Metadata.
     */
    private TablePayloadFormat payloadFormat;

    /**
     * Creates an instance of the <code>TableRequestOptions</code>
     */
    public TableRequestOptions() {
        super();
    }

    /**
     * Creates an instance of the <code>RequestOptions</code> class by copying values from another
     * <code>TableRequestOptions</code> instance.
     * 
     * @param other
     *            A <code>TableRequestOptions</code> object that represents the request options to copy.
     */
    public TableRequestOptions(final TableRequestOptions other) {
        super(other);
        if (other != null) {
            this.setTablePayloadFormat(other.getTablePayloadFormat());
            this.setPropertyResolver(other.getPropertyResolver());
        }
    }

    /**
     * Reserved for internal use. Initializes the values for this <code>TableRequestOptions</code> instance, if they are
     * currently <code>null</code>, using the values specified in the {@link CloudTableClient} parameter.
     * 
     * @param options
     *            The input options to copy from when applying defaults
     * @param client
     *            The {@link CloudTableClient} client object to copy the timeout and retry policy from.
     */
    protected static final TableRequestOptions applyDefaults(final TableRequestOptions options,
            final CloudTableClient client) {
        TableRequestOptions modifiedOptions = new TableRequestOptions(options);
        return TableRequestOptions.applyDefaultsInternal(modifiedOptions, client);
    }

    protected static final TableRequestOptions applyDefaultsInternal(TableRequestOptions modifiedOptions,
            CloudTableClient client) {
        Utility.assertNotNull("modifiedOptions", modifiedOptions);
        RequestOptions.applyBaseDefaultsInternal(modifiedOptions, client);

        if (modifiedOptions.getTablePayloadFormat() == null) {
            modifiedOptions.setTablePayloadFormat(client.getTablePayloadFormat());
        }

        return modifiedOptions;
    }

    /**
     * Gets the <see {@link TablePayloadFormat} that is used for any table accessed with this {@link TableRequest}
     * object. This will default to the value of the payload format of the {@link CloudTableClient} used to make the
     * request, which defaults to {@link TablePayloadFormat#Json}.
     * 
     * @return
     *         The {@link TablePayloadFormat} used by this {@link TableRequest}
     */
    public TablePayloadFormat getTablePayloadFormat() {
        return this.payloadFormat;
    }

    /**
     * Gets the interface that contains a function which is used to get the <see cref="EdmType"/> for an entity property
     * given the partition key, row, key, and the property name.
     * 
     * @return
     *         The property resolver in use
     */
    public PropertyResolver getPropertyResolver() {
        return this.propertyResolver;
    }

    /**
     * Sets the <see {@link TablePayloadFormat} that is used for any table accessed with this {@link TableRequest}
     * object.
     * 
     * @param payloadFormat
     *            The TablePayloadFormat to use.
     */
    public void setTablePayloadFormat(TablePayloadFormat payloadFormat) {
        this.payloadFormat = payloadFormat;
    }

    /**
     * Sets the interface that contains a function which is used to get the <see cref="EdmType"/> for an entity property
     * given the partition key, row, key, and the property name.
     * 
     * @param propertyResolver
     *            The property resolver to use.
     */
    public void setPropertyResolver(PropertyResolver propertyResolver) {
        this.propertyResolver = propertyResolver;
    }
}
