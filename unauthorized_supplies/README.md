
# Unauthorized supplies

This project is an implementation of the “Unauthorized Deliveries” task. It involves reading data from CSV files, adding a boolean field to indicate whether a delivery is authorized, and saving the data to a SQL database. The data can then be retrieved via a REST API.

## Getting Started

### Prerequisites

-   Docker
-   Docker Compose


### Running the Application with Docker Compose

To start the application using Docker Compose, follow these steps:

1. Ensure Docker and Docker Compose are installed on your machine.
2. Clone the repository: `git clone <repository-url>`
3. Navigate to the project directory: `cd <project-directory>`
4. (Optional) Adjust environment variables changing `*.env` files placed in `provision\docker\env` directory
5. Run the following command to start the application:
   ```bash
   docker-compose up -d
   ```

Access the application at http://localhost:8080 in your browser.

### Usage

This project reads data from two CSV files: `logins.csv` and `postings.csv`. The `logins.csv` file contains login data, and the `postings.csv` file contains delivery data.

### Testing with Postman

You can use Postman to test the REST API. Here’s how:

1.  Open Postman.
2.  Click on “Import” to import the provided Postman collection.
3.  In the Import dialog, click on “Upload Files” and select the JSON file with the Postman collection.
4.  After the collection is imported, you can see it in the Collections tab.
5.  In the collection, there is a request called “Get Postings by period and authorized”. This request fetches postings for a specific period and authorized status.
6.  Before sending the request, make sure to set the  `startDate`,  `endDate`, and  `authorized`  parameters to the desired values.
7.  Click on “Send” to send the request. The response will be displayed in the Response section.

## Contributing

Contributions are welcome. Please open an issue to discuss your idea or submit a pull request.

## Author

Dzmitry Shushkevich