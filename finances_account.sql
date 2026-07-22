create database finances_account;

-- 1. Tabla de Usuarios (Para tu registro e inicio de sesión)
CREATE TABLE users (
    pk_users serial4 PRIMARY KEY,
    username_user VARCHAR(100) NOT NULL,
    email_user VARCHAR(150) UNIQUE NOT NULL,
    password_hash_user VARCHAR(255) NOT NULL,
	active_user bool default true,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. Tabla de Entidades Bancarias (ej. MultiMoney, Banco Agrícola, etc.)
CREATE TABLE bank (
    pk_bank serial4 PRIMARY KEY,
    fk_users BIGINT REFERENCES users(pk_users) ON DELETE CASCADE,
    name_bank VARCHAR(100) NOT NULL,
    year_interest NUMERIC(5, 2) DEFAULT 0.00, -- ej. 3.50
	active_bank bool default true,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3. Tabla de Categorías (emergencias, imprevistos, inversión, etc.)
CREATE TABLE category (
    pk_category serial4 PRIMARY KEY,
    fk_bank BIGINT REFERENCES bank(pk_bank) ON DELETE CASCADE,
    name_category VARCHAR(100) NOT NULL,
    actual_balance NUMERIC(12, 2) DEFAULT 0.00,
	active_category bool default true,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 4. Tabla de Movimientos (Ingresos, Egresos y Capitalizaciones de Intereses)
CREATE TYPE movement_type AS ENUM ('INGRESO', 'EGRESO', 'INTERES');

CREATE TABLE movement (
    pk_movement serial4 PRIMARY KEY,
    fk_category BIGINT REFERENCES category(pk_category) ON DELETE CASCADE,
    ammount NUMERIC(12, 2) NOT NULL,
    type_movement_type movement_type NOT NULL,
    description VARCHAR(255),
	active_movement bool default true,
    movement_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);