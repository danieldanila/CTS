package suite;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses(AllTests.class)
@IncludeTags("important")
public class ImportantTests {
}
