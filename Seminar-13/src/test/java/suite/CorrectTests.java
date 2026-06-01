package suite;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses(AllTests.class)
@ExcludeTags({"right", "boundary", "inverse", "crosscheck", "error", "performance"})
public class CorrectTests {
}
