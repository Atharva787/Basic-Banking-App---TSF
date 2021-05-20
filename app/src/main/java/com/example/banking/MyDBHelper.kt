package com.example.banking

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class MyDBHelper(context: Context): SQLiteOpenHelper(context,"CUSTOMERS_DATA",null,1) {

    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "CUSTOMERS_DATA"
        private const val TABLE_NAME = "CUSTOMERS"

        private const val CUSTOMER_ID = "cid"
        private const val FNAME = "FirstName"
        private const val LNAME = "LastName"
        private const val EMAIL = "email"
        private const val BALANCE = "balance"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE CUSTOMERS(cid INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT, LNAME TEXT,EMAIL TEXT,BALANCE INTEGER)")

        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Atharva','Sawarkar','ath@gmail.com',100000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Rahul','Sharma','ravenclaw@hogwarts.com',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Wayne','Beck','sample@xyz',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Pranjal','Shukla','mramity@amity.in',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Radhesh','Sarma','prodhesh@gmail.com',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Harvey','Spectar','ceo@pearsonhardman',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Daniel','Hardman','brokegenious@gmail',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Ross','Taylor','beautyqueen@yahoo.in',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Cristiano','Ronaldo','sample@xyz',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Ramesh','Sahni','sample@xyz',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Suresh','Sinha','sample@xyz',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Peach','Salinger','sample@xyz',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Guinever','Beck','sample@xyz',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Pranjal','Shukla','mramity@amity.in',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Joe','Goldberg','sample@xyz',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Shubhang','Srivastav','sample@xyz',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Sanika','Khadkikar','sample@xyz',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Sanyam','Jain','sample@xyz',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Harry','Potter','griffindor@hogwarts',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Hermoine','Granger','hupplepuff@hogwarts',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Tony','Stark','ceo@starkindustries',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Ronald','Weasley','ravenclaw@hogwarts.com',10000)")


    }

    override fun onUpgrade(db:SQLiteDatabase, oldVersion: Int,newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun updateBalance(c: Customer) {
        val values = ContentValues()
        values.put(BALANCE, c.getBalance())

        val db: SQLiteDatabase = this.writableDatabase
        //val success = db.update(TABLE_CONTACTS, contentValues,"id="+emp.userId,null)
        val success = db.update(
            TABLE_NAME,
            values,
             " cid = " + c.getId(),
            null)

    }

}