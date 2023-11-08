create table users(
        id TEXT PRIMARY KEY UNIQUE NOT NULL ,
        login TEXT NOT NULL  UNIQUE ,
        passoword TEXT NOT NULL ,
        role TEXT NOT NULL
);