import activity.ExampleActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class ExampleActivityTest {

    @get:Rule
    val activityScenarioRule =
        ActivityScenarioRule(ExampleActivity::class.java)

    @Test
    fun test() {
        Espresso.onView(ViewMatchers.withId(android.R.id.content))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}