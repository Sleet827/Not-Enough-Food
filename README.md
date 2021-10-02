# Not-Enough-Food

This mod adds more food to minecraft, ranging from small things like chicken nuggets, to big ones like burgers and
pizzas.

# Making an addon:

If you want to make an addon to more food, like add some custom food to the cooked meat tag, you definitely can!

First, add these to lines of code to `gradle.properties`:

```properties
gpr.username=your_github_username
gpr.token=your_github_token
```

You can generate your token <a href="https://github.com/settings/tokens">here</a>.

Then, in your `build.gradle` file, create a new variable like so:

```groovy
def gpr_creds = {
    username = property('gpr.username')
    password = property('gpr.token')
}
```

Then in your `repositories` block, add this:

```groovy
maven {
    url = uri("https://maven.pkg.github.com/hackcoder1000/not-enough-food")
    credentials gpr_creds
}
```

Finally, in your `dependencies` block, add this line of code:

```groovy
compileOnly fg.deobf("net.legiblesleet827:not-enough-food:VERSION") {
    exclude module: 'forge'
}
```
