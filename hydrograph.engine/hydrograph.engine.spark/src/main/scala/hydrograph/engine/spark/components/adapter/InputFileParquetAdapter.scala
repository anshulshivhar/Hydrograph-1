/*******************************************************************************
 * Copyright 2017 Capital One Services, LLC and Bitwise, Inc.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package hydrograph.engine.spark.components.adapter

import hydrograph.engine.core.component.generator.InputFileParquetEntityGenerator
import hydrograph.engine.jaxb.commontypes.TypeBaseComponent
import hydrograph.engine.spark.components.InputFileParquetComponent
import hydrograph.engine.spark.components.adapter.base.InputAdatperBase
import hydrograph.engine.spark.components.base.InputComponentBase
import hydrograph.engine.spark.components.platform.BaseComponentParams
/**
  * The Class InputFileParquetAdapter.
  *
  * @author Bitwise
  *
  */
class InputFileParquetAdapter(typeBaseComponent: TypeBaseComponent) extends InputAdatperBase {

  private var inputFileParquet: InputFileParquetEntityGenerator = null
  private var iFileParquetComponent: InputFileParquetComponent = null

  override def createGenerator(): Unit = {
    inputFileParquet = new InputFileParquetEntityGenerator(typeBaseComponent)
  }

  override def createComponent(baseComponentParams: BaseComponentParams): Unit = {
    iFileParquetComponent = new InputFileParquetComponent(inputFileParquet.getEntity,
      baseComponentParams)
  }

  override def getComponent(): InputComponentBase = iFileParquetComponent
}