<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="common_resources.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <!-- ... (your existing head content) ... -->
    <title>Trending Technologies</title>

    <!-- Add a placeholder for the chart -->
    <style>
        canvas {
            max-width: 800px;
            margin: 20px 0;
        }
    </style>
</head>
<body>

    <%@ include file="normal_navbar.jsp" %>

    <div class="container mt-5">
        <h2>Trending Technologies</h2>

        <!-- Create a canvas for the bar chart -->
        <canvas id="trendingChart"></canvas>

        <!-- Pre-defined data for the bar chart -->
        <script>
            var labels = ['Artificial Intelligence', 'Machine Learning', 'Blockchain', 'Augmented Reality'];
            var data = [10, 8, 6, 4];

            // Render bar chart
            var ctx = document.getElementById('trendingChart').getContext('2d');
            var chart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: labels,
                    datasets: [{
                        label: 'Trending Technologies',
                        data: data,
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        </script>
    </div>

   

</body>
</html>
