package com.org.myapp.api.model;

import com.org.myapp.domain.model.AddressTypeEnum;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddressTest {

    private Validator validator;

    private Profile testProfile;

    @Before
    public void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();

        this.resetTestProfile();
    }

    private void resetTestProfile(){
        Profile profile = new Profile();
        profile.setId("6bfdbb48-c5f8-4d1f-8095-d9aee2425ea5");
        profile.setFirstName("first");
        profile.setMiddleName("middle");
        profile.setLastName("last");
        profile.setEmail("test@test.com");

        Address address = new Address();
        address.setId(1000);
        address.setType(AddressTypeEnum.HOME);
        address.setLineOne("123 line one");
        address.setLineTwo("123 line two");
        address.setCity("city");
        address.setState("state");
        address.setZipCode(12345);

        profile.setAddress(address);
        this.testProfile = profile;
    }

    @Test
    public void testLineOne_one(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test null line one
        this.testProfile.getAddress().setLineOne(null);
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLineOne_two(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test just space
        this.testProfile.getAddress().setLineOne(" ");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }


    @Test
    public void testLineOne_three(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test !
        this.testProfile.getAddress().setLineOne("123 line one!");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLineOne_four(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test .
        this.testProfile.getAddress().setLineOne("123 line one St.");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLineOne_five(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test (
        this.testProfile.getAddress().setLineOne("123 line one(");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLineOne_six(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test )
        this.testProfile.getAddress().setLineOne("123 line one)");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLineOne_seven(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test 41 characters
        this.testProfile.getAddress().setLineOne("abcd efgh ijkl mnop qrst uvwx yzab cdef a");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLineOne_eight(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test 4 characters
        this.testProfile.getAddress().setLineOne("abcd efgh ijkl mnop qrst uvwx yzab cdef ");
        violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());
    }

    @Test
    public void testLineTwo_one(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test line one can be null
        this.testProfile.getAddress().setLineTwo(null);
        violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());
    }

    @Test
    public void testLineTwo_two(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test just space is okay for now... todo
        this.testProfile.getAddress().setLineTwo(" ");
        violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());
    }


    @Test
    public void testLineTwo_three(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test !
        this.testProfile.getAddress().setLineTwo("123 line one!");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLineTwo_four(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test .
        this.testProfile.getAddress().setLineTwo("123 line one St.");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLineTwo_five(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test (
        this.testProfile.getAddress().setLineTwo("123 line one(");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLineTwo_six(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test )
        this.testProfile.getAddress().setLineTwo("123 line one)");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testCity_one(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test null
        this.testProfile.getAddress().setCity(null);
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testCity_two(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test just space
        this.testProfile.getAddress().setCity(" ");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }


    @Test
    public void testCity_three(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test !
        this.testProfile.getAddress().setCity("city!");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testCity_four(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test .
        this.testProfile.getAddress().setCity("this city.");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testCity_five(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test (
        this.testProfile.getAddress().setCity("this city(");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testCity_six(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test )
        this.testProfile.getAddress().setCity("city)");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testCity_seven(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test two word city is okay
        this.testProfile.getAddress().setCity("this city");
        violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());
    }

    @Test
    public void testState_one(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test null
        this.testProfile.getAddress().setState(null);
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testState_two(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test just space
        this.testProfile.getAddress().setState(" ");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }


    @Test
    public void testState_three(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test !
        this.testProfile.getAddress().setState("state!");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testState_four(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test .
        this.testProfile.getAddress().setState("this state.");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testState_five(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test (
        this.testProfile.getAddress().setState("this state(");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testState_six(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test )
        this.testProfile.getAddress().setState("state)");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testState_seven(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test two word state is okay
        this.testProfile.getAddress().setState("this state");
        violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());
    }

    @Test
    public void testZip_one(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test single number
        this.testProfile.getAddress().setZipCode(1);
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testZip_two(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test just under min
        this.testProfile.getAddress().setZipCode(9999);
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testZip_three(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test min is okay
        this.testProfile.getAddress().setZipCode(10000);
        violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());
    }

    @Test
    public void testZip_four(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test just over max
        this.testProfile.getAddress().setZipCode(100000);
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testZip_five(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test max is okay
        this.testProfile.getAddress().setZipCode(99999);
        violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());
    }

}
