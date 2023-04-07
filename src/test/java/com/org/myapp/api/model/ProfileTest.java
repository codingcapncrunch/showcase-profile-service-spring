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

public class ProfileTest {

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
    public void testId_one(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        this.testProfile.setId("bogus");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testId_two(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        //removed last digit
        this.testProfile.setId("6bfdbb48-c5f8-4d1f-8095-d9aee2425ea");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testId_three(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        //added space
        this.testProfile.setId("6bfdbb48-c5f8- 4d1f-8095-d9aee2425ea5");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testId_four(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        //added space removed last digit
        this.testProfile.setId("6bfdbb48-c5f8- 4d1f-8095-d9aee2425ea");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testId_five(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        //added special character !
        this.testProfile.setId("6bfdbb48-c5f8-4d1f-8095-d9aee2425ea!");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testId_six(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        //added special character (
        this.testProfile.setId("6bfdbb48-c5f8-4d1f-8095-d9aee2425ea(");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testId_seven(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        //added special character )
        this.testProfile.setId("6bfdbb48-c5f8-4d1f-8095-d9aee2425ea)");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testId_eight(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // removed random substring values
        this.testProfile.setId("6b48-c5f8-4d1f-8095-d2a5");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testFirstName_one(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // null firstname check
        this.testProfile.setFirstName(null);
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testFirstName_two(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with space
        this.testProfile.setFirstName("test test");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testFirstName_three(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with !
        this.testProfile.setFirstName("test!");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testFirstName_four(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with just space
        this.testProfile.setFirstName(" ");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testFirstName_five(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with (
        this.testProfile.setFirstName("(");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testFirstName_six(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with )
        this.testProfile.setFirstName(")");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testFirstName_seven(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with numbers
        this.testProfile.setFirstName("123");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testFirstName_eight(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with .
        this.testProfile.setFirstName(".");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testMiddleName_one(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // null firstname check
        this.testProfile.setMiddleName(null);
        violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());
    }

    @Test
    public void testMiddleName_two(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with space
        this.testProfile.setMiddleName("test test");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testMiddleName_three(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with !
        this.testProfile.setMiddleName("test!");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testMiddleName_four(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with just space
        this.testProfile.setMiddleName(" ");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testMiddleName_five(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with (
        this.testProfile.setMiddleName("(");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testMiddleName_six(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with )
        this.testProfile.setMiddleName(")");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testMiddleName_seven(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with numbers
        this.testProfile.setMiddleName("123");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testMiddleName_eight(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with .
        this.testProfile.setMiddleName(".");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLastName_one(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // null firstname check
        this.testProfile.setLastName(null);
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLastName_two(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with space
        this.testProfile.setLastName("test test");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLastName_three(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with !
        this.testProfile.setLastName("test!");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLastName_four(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with just space
        this.testProfile.setLastName(" ");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLastName_five(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with (
        this.testProfile.setLastName("(");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLastName_six(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with )
        this.testProfile.setLastName(")");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLastName_seven(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with numbers
        this.testProfile.setLastName("123");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testLastName_eight(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // firstname with .
        this.testProfile.setLastName(".");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testEmail_one(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test without @
        this.testProfile.setEmail("test.com");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testEmail_two(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test without anything before @
        this.testProfile.setEmail("@test.com");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testEmail_three(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test without anything after @
        this.testProfile.setEmail("test@");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testEmail_four(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test with ! ... appearantly this is acceptable!
        this.testProfile.setEmail("!test@test.com");
        violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());
    }

    @Test
    public void testEmail_five(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test with (
        this.testProfile.setEmail("(test@test.com");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testEmail_six(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test with null
        this.testProfile.setEmail(null);
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testEmail_seven(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test without @ or .com
        this.testProfile.setEmail("test");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testEmail_eight(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test with " "
        this.testProfile.setEmail(" ");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testEmail_nine(){

        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test with )
        this.testProfile.setEmail(")@test.com");
        violationSet = this.validator.validate(this.testProfile);
        assertFalse(violationSet.isEmpty());
    }

    @Test
    public void testAddress_one(){
        this.resetTestProfile();
        Set<ConstraintViolation<Profile>> violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());

        // test null address is okay
        this.testProfile.setAddress(null);
        violationSet = this.validator.validate(this.testProfile);
        assertTrue(violationSet.isEmpty());
    }
}
