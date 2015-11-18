/*
 * Copyright 2015 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibm.spark.interpreter.broker

import com.ibm.spark.interpreter.broker.producer.{SQLContextProducerLike, JavaSparkContextProducerLike}
import com.ibm.spark.kernel.api.KernelLike
import org.apache.spark.api.java.JavaSparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Represents the API available to the broker to act as the bridge for data
 * between the JVM and some external process.
 *
 * @param _brokerState The container of broker state to expose
 * @param _kernel The kernel API to expose through the bridge
 */
class BrokerBridge(
  private val _brokerState: BrokerState,
  private val _kernel: KernelLike
) extends BrokerName {
  /**
   * Represents the current state of the broker.
   */
  val state: BrokerState = _brokerState

  /**
   * Represents the kernel API available.
   */
  val kernel: KernelLike = _kernel
}
