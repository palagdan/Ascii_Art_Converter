# ASCII Art 

## Command-line Options
The program supports the following command-line options:

### Image Loading Options

- Specify the input image file in JPG or PNG format:
```console
--image <filename>
```  
- Load a random image:
```console
--image-random 
 ```
### Image Filtering Options
- Apply the invert filter to the image:
```console 
--invert
```
Adjust the brightness of the image. Provide an integer value:
```console
--brightness <value>
```
#### Flip Filters
- Flip the image horizontally: 
```console
--flip x
```
- Flip the image vertically:
```console
--flip y
```
- You can combine two arguments:
```console
--flip x y
```

### Output Options
- Save the processed image to the specified file:
```console
--output-file <filename>
```
- Display the processed image on the console:
```console
--output-console
```

### ASCII Table Options
- Specify the ASCII table configuration. Available options: (provide the table name or custom configuration):
```console
--table <tablename>
```
Predefined tables:
```console
    "bourke-small" -> "@%#*+=-:,. "
    "bourke-large" -> "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ",```
        "non-linear-large" -> "@@@@@@@@@@@@@@@@@@@@@$%^&*+++++++++++++^^^^^^^^^^^!!!!!!!!..............                   "
    "non-linear-medium" -> "@@%++**----:;~,  "
    "non-linear-small" -> "@@%++**--  "
    "non-linear-xlarge" -> "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%++**----:;~,~~~~~~~~~~~~~..............................                               "
    "default  -> "@%#*+=-:,.       "
```

