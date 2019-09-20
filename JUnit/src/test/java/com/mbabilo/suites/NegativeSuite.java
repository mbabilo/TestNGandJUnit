package com.mbabilo.suites;

import com.mbabilo.tests.SimpleTests;
import com.mbabilo.categoryInterface.MyCategories;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@SuiteClasses({
  SimpleTests.class
})
@RunWith(Categories.class)
@IncludeCategory(MyCategories.NegativeTests.class)
public class NegativeSuite {

}
