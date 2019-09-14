package com.mbabilo.tests.suites;

import com.mbabilo.tests.categoryInterface.MyCategories;
import com.mbabilo.tests.tests.SimpleTests;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@SuiteClasses({
  SimpleTests.class
})
@RunWith(Categories.class)
@IncludeCategory(MyCategories.PositiveTests.class)
public class PositiveSuite {

}
