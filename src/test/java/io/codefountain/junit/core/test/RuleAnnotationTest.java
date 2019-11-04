package io.codefountain.junit.core.test;

import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.Is.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

public class RuleAnnotationTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testArrayIndexOutOfBoundsException(){
        expectedException.expect(IndexOutOfBoundsException.class);
        expectedException.expectMessage(containsString("Index: 5, Size: 0"));

        new ArrayList<String>().get(5);
    }

    @Test
    public void testReservationIdValidator(){
        expectedException.expect(InvalidReservationIdException.class);
        expectedException.expect(hasProperty("id"));

        new ReservationServiceValidator().validateId(0);
    }


    class InvalidReservationIdException extends RuntimeException{
        private int id;

        public InvalidReservationIdException(int id, String errorMessage){
            super(errorMessage);
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    class ReservationServiceValidator{

        public void validateId(int id){
            if(id ==0 ){
                throw new InvalidReservationIdException(id, "Invalid reservation Id");
            }
        }
    }
}
