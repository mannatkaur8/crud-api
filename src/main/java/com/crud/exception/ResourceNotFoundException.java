 package com.crud.exception; // change to com.crud.exception if you created an exception package

    public class ResourceNotFoundException extends RuntimeException {

        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

