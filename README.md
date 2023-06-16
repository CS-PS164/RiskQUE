# RiskQUE
Your fund advisor using Machine Learning

# Local Development Setup

This is a step-by-step guide on setting up and running a FastAPI app locally. It assumes you have basic knowledge of Python and are comfortable working with the command line.

## Prerequisites

Before getting started, make sure you have the following installed on your machine:

- Python 3.7+
- pip (Python package installer)

## Setup

### 1. Clone the Repository

Clone the repository containing your FastAPI app code to your local machine.

```shell
$ git clone https://github.com/CS-PS164/RiskQUE
$ cd RiskQUE
```

### 2. Create and Activate a Virtual Environment

Create a virtual environment to isolate the app's dependencies.

```shell
$ python3 -m venv venv
```

Activate the virtual environment:

For Windows:

```shell
$ venv\Scripts\activate
```
For Unix/macOS:

```shell
$ source venv/bin/activate
```

### 3. Install Dependencies

Install the required Python dependencies using pip.

```shell
$ pip install -r requirements.txt
```

### 4. Run the App
You can run the app using the following command:

```shell
$ uvicorn main:app --reload
```
