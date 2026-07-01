# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Java vending machine application built with Maven. Uses Java 25. No frameworks — plain Java.

## Your Task

1. Read progress.txt to see what has been completed.
2. Find the highest-priority incomplete task from PRD.md.
3. Check you're on the correct branch from PRD `branchName`. If not, check it out or create from main.
4. Implement that single task.
5. Write unit tests for any code with logic.
6. Verify: ./mvnw compile -q && ./mvnw test -q 
7. If tests pass, git add and commit with a conventional commit message (feat:, fix:, test:, refactor:).
8. Mark the task complete in PRD.md (change [ ] to [x]).
9. If checks pass, commit ALL changes with message: `feat: [Story ID] - [Story Title]`
10. Update CLAUDE.md files if you discover reusable patterns (see below)
11. Append your progress to progress.txt with what you completed.
12. Push the branch to origin (`git push origin <branch-name>`).
13.Provide the user with the GitHub PR link.
14. If ALL tasks in PRD.md are complete, output <promise>COMPLETE</promise>.
ONLY WORK ON ONE TASK PER ITERATION.



## Build Commands

```bash
./mvnw compile -q          # Compile
./mvnw test -q             # Run all tests
./mvnw compile -q && ./mvnw test -q   # Compile and test (used by ralph.sh)
```

No Maven wrapper (`mvnw`) is included yet — it will need to be generated before building.

## Architecture

This is a skeleton project under `dev.danvega` group. Source code goes in `src/main/java/`, tests in `src/test/java/`. No dependencies or test framework are declared in `pom.xml` yet.

## Automated Development Workflow

`ralph.sh` drives iterative development: it reads `PRD.md` for requirements, tracks completed work in `progress.txt`, and calls Claude to implement one task per iteration, verifying compilation and tests pass before committing.


## Testing

### Stack
- JUnit 6
- AssertJ for assertions
- Mockito for mocking (when needed)

### Conventions
- Test classes in `src/test/java` mirroring main package structure
- Test class naming: `{ClassName}Test.java`
- Test method naming: `methodName_scenario_expectedResult`
- Use @DisplayName for readable test names
- Given/When/Then comments for clarity

### Example
```java
class SlotTest {

    @Test
    @DisplayName("isInStock returns true when quantity is greater than zero")
    void isInStock_withPositiveQuantity_returnsTrue() {
        // Given
        var slot = new Slot(Product.COLA, 5);
        
        // When
        boolean result = slot.isInStock();
        
        // Then
        assertThat(result).isTrue();
    }
    
    @Test
    @DisplayName("decrementQuantity reduces quantity by one")
    void decrementQuantity_whenInStock_reducesQuantity() {
        // Given
        var slot = new Slot(Product.COLA, 3);
        
        // When
        slot.decrementQuantity();
        
        // Then
        assertThat(slot.getQuantity()).isEqualTo(2);
    }
}
```

### What to Test
- Public methods with logic
- Edge cases (empty, null, zero, negative)
- Error conditions
- Skip trivial getters/setters and simple enums without methods