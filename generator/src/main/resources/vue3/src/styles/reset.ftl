/**
 * ENGINE
 * v0.2 | 20150615
 * License: none (public domain)
 */

*,
*:after,
*:before {
  box-sizing: border-box;

  outline: none;
}

html,
body,
div,
span,
applet,
object,
iframe,
h1,
h2,
h3,
h4,
h5,
h6,
p,
blockquote,
pre,
a,
abbr,
acronym,
address,
big,
cite,
code,
del,
dfn,
em,
img,
ins,
kbd,
q,
s,
samp,
small,
strike,
strong,
sub,
sup,
tt,
var,
b,
u,
i,
center,
dl,
dt,
dd,
ol,
ul,
li,
fieldset,
form,
label,
legend,
table,
caption,
tbody,
tfoot,
thead,
tr,
th,
td,
article,
aside,
canvas,
details,
embed,
figure,
figcaption,
footer,
header,
hgroup,
menu,
nav,
output,
ruby,
section,
summary,
time,
mark,
audio,
video {
  font: inherit;
  font-size: 100%;

  margin: 0;
  padding: 0;

  vertical-align: baseline;

  border: 0;
}

article,
aside,
details,
figcaption,
figure,
footer,
header,
hgroup,
menu,
nav,
section {
  display: block;
}

body {
  line-height: 1;
}

ol,
ul {
  list-style: none;
}

blockquote,
q {
  quotes: none;
  &:before,
  &:after {
    content: '';
    content: none;
  }
}

sub,
sup {
  font-size: 75%;
  line-height: 0;

  position: relative;

  vertical-align: baseline;
}
sup {
  top: -0.5em;
}
sub {
  bottom: -0.25em;
}

table {
  border-spacing: 0;
  border-collapse: collapse;
}

input,
textarea,
button {
  font-family: inhert;
  font-size: inherit;

  color: inherit;
}

select {
  text-indent: 0.01px;
  text-overflow: '';

  border: 0;
  border-radius: 0;

  -webkit-appearance: none;
  -moz-appearance: none;
}
select::-ms-expand {
  display: none;
}

code,
pre {
  font-family: monospace, monospace;
  font-size: 1em;
}
