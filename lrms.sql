-- Create the 'lawyerrecord' table if it does not already exist
CREATE TABLE IF NOT EXISTS public.lawyerrecord
(
    -- Number of cases handled by the lawyer
    lawyercase INTEGER,

    -- Years of experience the lawyer has
    lawyerexperience INTEGER,

    -- Lawyer's win ratio
    lawyerwl REAL,

    -- Lawyer's phone number (up to 15 characters)
    lawyerphonenumber CHARACTER VARYING(15) COLLATE pg_catalog."default",

    -- Domain of law expertise of the lawyer (e.g., Civil, Criminal)
    lawyerdomain CHARACTER VARYING(30) COLLATE pg_catalog."default",

    -- License number of the lawyer
    lawyerlicense CHARACTER VARYING(30) COLLATE pg_catalog."default",

    -- Status of the lawyer (e.g., Active, Inactive)
    lawyerstatus CHARACTER VARYING(30) COLLATE pg_catalog."default",

    -- Unique ID of the lawyer (Primary Key, mandatory field)
    lawyerid CHARACTER VARYING(40) COLLATE pg_catalog."default" NOT NULL,

    -- Name of the lawyer (up to 50 characters)
    lawyername CHARACTER VARYING(50) COLLATE pg_catalog."default",

    -- Address of the lawyer (up to 200 characters)
    lawyeraddress CHARACTER VARYING(200) COLLATE pg_catalog."default",

    -- Primary Key constraint on the lawyerid column
    CONSTRAINT lawyerrecord_pkey PRIMARY KEY (lawyerid)
);
