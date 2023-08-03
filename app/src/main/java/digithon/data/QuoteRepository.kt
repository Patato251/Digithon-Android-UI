/*
 * Copyright (C) 2022 The Android Open Source Project
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

package digithon.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import digithon.data.local.database.Quote
import digithon.data.local.database.QuoteDao
import javax.inject.Inject

interface QuoteRepository {
    val quotes: Flow<List<String>>

    suspend fun add(name: String)
}

class DefaultQuoteRepository @Inject constructor(
    private val quoteDao: QuoteDao
) : QuoteRepository {

    override val quotes: Flow<List<String>> =
        quoteDao.getQuotes().map { items -> items.map { it.name } }

    override suspend fun add(name: String) {
        quoteDao.insertQuote(Quote(name = name))
    }
}
