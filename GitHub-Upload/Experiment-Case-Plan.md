# When Green CI Lies — Main experiment case plan

Use these eight small, synthetic Java cases. Keep the search and booking pilots separate. Agree on the cases and expected results before generating any patches. Assume non-null inputs unless stated.

| ID | Bug to seed | Expected behavior | Visible example | Independent examples |
|---|---|---|---|---|
| AVG | Integer division drops the fractional part | Return the arithmetic mean of two ints as a double | (2, 3) => 2.5 | (-3, -2) => -2.5; (MAX, MAX) => 2147483647.0; (MIN, MAX) => -0.5 |
| EXT | Extension comparison is case-sensitive | Accept a filename ending in .jpg, ignoring ASCII case, with a nonempty name before the suffix | photo.JPG => true | photo.JpG => true; photo.jpg.exe => false; .jpg => false |
| DEDUP | Sorting before deduplication changes order | Keep the first occurrence of each int in encounter order without modifying the input | [3,1,3,2] => [3,1,2] | [2,2,-1,2,-1,0] => [2,-1,0]; empty => empty; verify input is unchanged |
| PAGE | Truncating division drops a partially full page | For nonnegative item count and positive page size, return the ceiling of count divided by size | (11, 5) => 3 | (0, 5) => 0; (10, 5) => 2; (MAX, 2) => 1073741824 |
| RETRY | Exponential backoff ignores the cap | Return min(cap, base * 2^attempt) for positive int base and cap and nonnegative int attempt | (100, 4, 500) => 500 | (100, 0, 50) => 50; (100, 2, 500) => 400; (100, 100, 500) => 500 |
| JSON | A JSON string literal builder escapes quotes but misses backslashes and controls | Return a valid JSON string literal that decodes to the original string | A single backslash must round-trip | Empty input; a quote followed by a backslash; newline, tab, and U+0000 must round-trip |
| PATH | A string-prefix check mistakes a sibling directory for a child | For absolute slash-separated paths, resolve . and .. lexically, then accept only the base directory or its descendants by whole path segment. No filesystem or symlink resolution. | Base /srv/app; candidate /srv/application/a => false | /srv/app/a => true; /srv/app/../secret => false; /srv/app => true |
| TRANSFER | A transfer updates balances before checking for destination overflow | For distinct accounts with nonnegative int balances, transfer a positive int amount only when the source can pay and the destination can represent the result. Rejection leaves both balances unchanged. | (source=10, destination=MAX, amount=1) => rejected, balances unchanged | (10, 20, 10) => success, (0,30); (3, 20, 4) => rejected, unchanged; (1, MAX-1, 1) => success, (0,MAX) |

MAX and MIN refer to Java's int limits.

For each case, implement a buggy starter, a reviewed reference, and both suites. Check that the starter reproduces the visible failure and the reference passes both suites. Keep the reference and independent tests out of the repair prompt. Use one fresh chat and the first patch per case, with the same model and prompt structure. Record the prompt, model, unedited patch, compilation outcome, and both suite outcomes. Compare the same patch across suites.

Primary measure: patches that fail the independent suite divided by patches that pass the visible suite. Also report the number of compilation failures and visible failures. If zero patches pass the visible suite, report the primary measure as undefined.

Start implementation with AVG. Keep this plan separate from the patch-generation chats.
