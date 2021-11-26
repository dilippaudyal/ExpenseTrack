package com.moneylion.codechallenge.expensetrack.app

import android.app.Application
import com.moneylion.codechallenge.expensetrack.data.local.database.TransactionRoomDatabase
import com.moneylion.codechallenge.expensetrack.repo.TransactionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class TransactionApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { TransactionRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { TransactionRepository(database.transactionDAO()) }

}