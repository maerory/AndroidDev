package net.n1books.dev.sqlitetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper helper;
    private static String dbname = "mymember.db";
    private static String tableName = "t_member";
    private static String createTable =
            "create table " + tableName + "(" +
                    "name text primary key, " +
                    "email text, phone text, age integer)";

    EditText edtName, edtEmail, edtPhone, edtAge, edtEtc;

    String name, email, phone, etc;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        edtAge = findViewById(R.id.edtAge);
        edtEtc = findViewById(R.id.edtEtc);

        helper = new SQLiteOpenHelper(this, dbname, null, 6) {
            @Override
            public void onCreate(SQLiteDatabase db) {
                String sql = "select count(*) as cnt from sqlite_master " +
                        "where name=?";
                Cursor c = db.rawQuery(sql, new String[]{tableName});

                if (c.moveToNext()) {
                    int count = c.getInt(c.getColumnIndex("cnt"));
                    if (count == 0) {
                        Log.d("c504", "★★★★★Table Created.★★★★★");
                        db.execSQL(createTable);
                    } else {
                        Log.d("c504", "★★★★★Table Exists.★★★★★");
                    }
                } else {
                    Log.d("c504", "★★★★★Sqlite Error★★★★★");
                }
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                try {
                    Log.d("c504", "★★★★★Table already exists, modifying table★★★★★");
                    db.execSQL("alter table " + tableName + " add column etc text ");
                    //onCreate(db);
                } catch (Exception e) {
                    Log.d("c504", "Error: Check DB conection.");
                }
            }
        };
        db = helper.getWritableDatabase(); //Opens the database
    }

    public void btnInsert_onClick(View v) {
        try {
            name = edtName.getText().toString().trim();
            email = edtEmail.getText().toString().trim();
            phone = edtPhone.getText().toString().trim();
            age = Integer.parseInt(edtAge.getText().toString().trim());
            etc = edtEtc.getText().toString().trim();
            if (name.equals("")) {
                Snackbar.make(v, "Input Name!", Snackbar.LENGTH_SHORT)
                        .setAction("Click", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                edtName.requestFocus();
                            }
                        }).show();
            } else if (email.equals("")) {
                Snackbar.make(v, "Input Email!", Snackbar.LENGTH_SHORT)
                        .setAction("Click", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                edtEmail.requestFocus();
                            }
                        }).show();
            } else if (phone.equals("")) {
                Snackbar.make(v, "Input Phone!", Snackbar.LENGTH_SHORT)
                        .setAction("Click", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                edtPhone.requestFocus();
                            }
                        }).show();
            } else if (etc.equals("")) {
                Snackbar.make(v, "Input Etc!", Snackbar.LENGTH_SHORT)
                        .setAction("Click", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                edtEtc.requestFocus();
                            }
                        }).show();
            }
        } catch (NumberFormatException e) {
            Snackbar.make(v, "Input Age!", Snackbar.LENGTH_SHORT)
                    .setAction("Click", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            edtAge.requestFocus();
                        }
                    }).show();
        }
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("email", email);
        cv.put("phone", phone);
        cv.put("age", age);
        cv.put("etc", etc);
        try {
            long result = db.insert(tableName, null, cv);
            if (result == -1) throw new RuntimeException();
            Snackbar.make(v, "Input Success", Snackbar.LENGTH_SHORT)
                    .setAction("Click", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                        }
                    }).show();
        } catch (Exception e) {
            e.printStackTrace();
            Snackbar.make(v, "ERROR!!!!!", Snackbar.LENGTH_SHORT)
                    .setAction("Click", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                        }
                    }).show();
        }
    }

    public void btnUpdate_onClick(View v) {
        try {
            name = edtName.getText().toString().trim();
            email = edtEmail.getText().toString().trim();
            phone = edtPhone.getText().toString().trim();
            age = Integer.parseInt(edtAge.getText().toString().trim());
            etc = edtEtc.getText().toString().trim();
            if (name.equals("")) {
                Snackbar.make(v, "Input Name!", Snackbar.LENGTH_SHORT)
                        .setAction("Click", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                edtName.requestFocus();
                            }
                        }).show();
            } else if (email.equals("")) {
                Snackbar.make(v, "Input Email!", Snackbar.LENGTH_SHORT)
                        .setAction("Click", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                edtEmail.requestFocus();
                            }
                        }).show();
            } else if (phone.equals("")) {
                Snackbar.make(v, "Input Phone!", Snackbar.LENGTH_SHORT)
                        .setAction("Click", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                edtPhone.requestFocus();
                            }
                        }).show();
            } else if (etc.equals("")) {
                Snackbar.make(v, "Input Etc!", Snackbar.LENGTH_SHORT)
                        .setAction("Click", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                edtEtc.requestFocus();
                            }
                        }).show();
            }
        } catch (NumberFormatException e) {
            Snackbar.make(v, "Input Age!", Snackbar.LENGTH_SHORT)
                    .setAction("Click", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            edtAge.requestFocus();
                        }
                    }).show();
        }
        Log.d("c503", "ready to modify!");
        ContentValues cv = new ContentValues();
        cv.put("email", email);
        cv.put("phone", phone);
        cv.put("age", age);
        cv.put("etc", etc);
        long result = db.update(tableName, cv, "name=?", new String[]{name});
        if (result == -1) throw new RuntimeException();
        Snackbar.make(v, "Modify Success", Snackbar.LENGTH_SHORT)
                .setAction("Click", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                }).show();
    }
    public void btnDelete_onClick(View v) {
        try {
            long result = db.delete(tableName, "name=?", new String[]{edtName.getText().toString()});
            if (result == -1) throw new RuntimeException();
            Snackbar.make(v, "Delete Success", Snackbar.LENGTH_SHORT)
                    .setAction("Click", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                        }
                    }).show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void btnFind_onClick(View v) {
        String[] columns = {"email","phone","age","etc"};
        String selection = "name=?";
        Cursor c = db.query(tableName, columns, selection, new String[]{edtName.getText().toString()},
                null,null,null);
        if (c.moveToNext()) {
            edtEmail.setText(c.getString(c.getColumnIndex("email")));
            edtPhone.setText(c.getString(c.getColumnIndex("phone")));
            edtAge.setText(c.getString(c.getColumnIndex("age")));
            edtEtc.setText(c.getString(c.getColumnIndex("etc")));

        }
    }
    @Override
    public void onDestroy() {
        db.close();
        super.onDestroy();
    }
}
