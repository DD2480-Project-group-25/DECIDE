# Branches
A desired change to the `master` branch should be described in an issue.

A branch to make that change is then created.

That branch should be named based upon the issues it addresses. The branch should be named `issue/{issues-number}` where
`{issue-number}` should be the GitHub assigned issue number, e.g. `issue/15` for the
[LIC0 issue](https://github.com/DD2480-Project-group-25/DECIDE/issues/1).

# Squash commit messages
Seven rules for a great commit message from [Chris Beams](https://chris.beams.io/posts/git-commit/).
1. Separate subject from body with a blank line
2. Limit the subject line to 50 characters
3. Capitalize the subject line
4. Do not end the subject line with a period
5. Use the imperative mood in the subject line
6. Wrap the body at 72 characters
7. Use the body to explain what and why vs. how

## An Example
```
Implement LIC0 - fix #1

#Explain what here

#Explain why here

#Explain how here
```