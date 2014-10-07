package tdd.samples.category.testsuite;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import tdd.samples.category.Nightly;
import tdd.samples.category.tests.VerifyCallATest;
import tdd.samples.category.tests.VerifyCallBTest;
import tdd.samples.category.tests.VerifyCallCTest;
import tdd.samples.category.tests.VerifyCallDTest;

@RunWith(Categories.class)
@SuiteClasses({
	VerifyCallATest.class,
	VerifyCallBTest.class,
	VerifyCallCTest.class,
	VerifyCallDTest.class
})

/**
 * Test suite only containing tests of category 'Nightly'.
 */
@IncludeCategory(Nightly.class)
public class NightlyTestSuite {
}
