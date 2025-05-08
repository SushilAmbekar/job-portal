// API base URL
const apiUrl = 'http://localhost:8080/jobs';

// Fetch all jobs and display them
function fetchJobs() {
    fetch(apiUrl)
        .then(response => response.json())
        .then(jobs => {
            const jobList = document.getElementById('jobList');
            jobList.innerHTML = '';  // Clear the current job list
            jobs.forEach(job => {
                const jobItem = document.createElement('div');
                jobItem.classList.add('jobItem');
                jobItem.innerHTML = `
                    <strong>${job.title}</strong><br>
                    ${job.company}<br>
                    ${job.description}<br>
                    ${job.location}<br>
                    <button onclick="deleteJob(${job.id})">Delete</button>
                `;
                jobList.appendChild(jobItem);
            });
        });
}

// Add new job
document.getElementById('addJobForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const newJob = {
        title: document.getElementById('title').value,
        company: document.getElementById('company').value,
        description: document.getElementById('description').value,
        location: document.getElementById('location').value
    };

    fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newJob)
    })
    .then(response => response.json())
    .then(() => {
        alert('Job added successfully');
        fetchJobs();  // Refresh the job list
    })
    .catch(err => console.error('Error:', err));
});

// Delete a job
function deleteJob(id) {
    fetch(`${apiUrl}/${id}`, {
        method: 'DELETE'
    })
    .then(() => {
        alert('Job deleted');
        fetchJobs();  // Refresh the job list
    })
    .catch(err => console.error('Error:', err));
}

// Initial fetch to display jobs
fetchJobs();
