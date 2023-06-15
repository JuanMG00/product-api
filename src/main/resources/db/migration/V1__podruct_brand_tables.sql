CREATE TABLE BRAND
(
    ID   INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL
);

CREATE TABLE PRODUCT
(
    ID    INT AUTO_INCREMENT PRIMARY KEY,
    NAME  VARCHAR(100) NOT NULL
);


CREATE TABLE PRICE_LIST
(
    ID       INT AUTO_INCREMENT PRIMARY KEY,
    ZONE VARCHAR(50)    NOT NULL,
    RATE     DECIMAL(10, 2) NOT NULL
);

CREATE TABLE PRICES (
                        ID         INT AUTO_INCREMENT PRIMARY KEY,
                        BRAND_ID   INT NOT NULL,
                        START_DATE TIMESTAMP NOT NULL,
                        END_DATE   TIMESTAMP NOT NULL,
                        PRICE_LIST INT NOT NULL,
                        PRODUCT_ID INT NOT NULL,
                        PRIORITY   INT NOT NULL,
                        PRICE      DECIMAL(10, 2) NOT NULL,
                        CURR       VARCHAR(3) NOT NULL,
                        FOREIGN KEY (BRAND_ID) REFERENCES BRAND (ID),
                        FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (ID),
                        FOREIGN KEY (PRICE_LIST) REFERENCES PRICE_LIST (ID),
                        CHECK (END_DATE >= START_DATE) -- Constraint to check end date not smaller than start date
);

-- Add the check constraint
ALTER TABLE PRICES
    ADD CONSTRAINT CHK_PRICES_NO_DUPLICATE
        CHECK (
            NOT EXISTS (
                    SELECT 1
                    FROM PRICES p
                    WHERE p.START_DATE <= PRICES.END_DATE
                      AND p.END_DATE >= PRICES.START_DATE
                      AND p.PRODUCT_ID = PRICES.PRODUCT_ID
                      AND p.PRIORITY = PRICES.PRIORITY
                      AND p.ID <> PRICES.ID
                )
            );


