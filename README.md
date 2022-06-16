# fwpd

The FWPD has a fancy new database technology called CSV (comma-separated values). Your job is to parse this state-of-the-art CSV and analyze it for potential vampires. We’ll do that by filtering on each suspect’s glitter index, a 0–10 prediction of the suspect’s vampireness developed by some teenage girl.

## Installation

Clone de project

## Usage

```
lein repl
```

## Examples

```
    (glitter-filter 3 (mapify (parse (slurp filename))))
```

Turn the result of your glitter filter into a list of names.
```
    (map :name (glitter-filter 3 (mapify (parse (slurp filename)))))
```



### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2022 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
