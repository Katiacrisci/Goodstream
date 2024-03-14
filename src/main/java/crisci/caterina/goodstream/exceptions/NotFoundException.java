package crisci.caterina.goodstream.exceptions;

    public class NotFoundException extends RuntimeException {
        public NotFoundException(Long id) {
            super("User with id " + id + " not found");
        }

        public NotFoundException(String message) {
            super(message);
        }
    }

