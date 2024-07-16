<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="common_resources.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Trending Technologies</title>

    <!-- Add a placeholder for the chart -->
    <style>
        canvas {
            max-width: 800px;
            margin: 20px 0;
        }
    </style>

    <!-- Include Chart.js library -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
 <div class="container mt-5">
        <div class="text-center">
            <h1 class="display-4">Trending Technologies Chart</h1>
            <p class="lead">Explore the popularity of trending technologies based on the number of mentions.</p>
        </div>

        <!-- Create a canvas for the bar chart -->
        <canvas id="trendingChart" class="mx-auto"></canvas>

        <!-- Pre-defined data for the bar chart -->
        <script>
            var labels = ['Artificial Intelligence', 'Machine Learning', 'Blockchain', 'Augmented Reality'];
            var data = [10, 8, 6, 4];

            // Render a visually appealing bar chart with animations
            var ctx = document.getElementById('trendingChart').getContext('2d');
            var chart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: labels,
                    datasets: [{
                        label: 'Trending Technologies',
                        data: data,
                        backgroundColor: 'rgba(75, 192, 192, 0.8)', // Gradient color
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 2,
                        borderRadius: 10 // Rounded bars
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true,
                            title: {
                                display: true,
                                text: 'Number of Mentions'
                            }
                        }
                    },
                    plugins: {
                        legend: {
                            display: false // Hide legend
                        },
                        tooltip: {
                            mode: 'index',
                            intersect: false,
                            callbacks: {
                                label: function(context) {
                                    var label = context.dataset.label || '';
                                    if (label) {
                                        label += ': ';
                                    }
                                    label += context.parsed.y;
                                    return label;
                                }
                            }
                        }
                    },
                    animation: {
                        duration: 2000, // Animation duration in milliseconds
                        easing: 'easeInOutQuart' // Easing function for the animation
                    }
                }
            });
            
            
            
        </script>
    </div>

    

</body>
</html>
